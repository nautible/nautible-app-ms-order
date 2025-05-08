package jp.co.ogis_ri.nautible.app.order.inbound.rest;

import java.util.function.Function;
import java.util.logging.Logger;
import java.util.logging.Level;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.inject.Inject;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.State;
import jp.co.ogis_ri.nautible.app.order.api.rest.RestCart;
import jp.co.ogis_ri.nautible.app.order.api.rest.RestCartService;
import jp.co.ogis_ri.nautible.app.order.core.rest.MDC;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * REST APIのカートサービス。REST APIのエンドポイント。
 */
@MDC
public class RestCartServiceImpl implements RestCartService {

    Logger LOG = Logger.getLogger(RestCartServiceImpl.class.getName());

    /** daprのstatestore名 */
    private static final String STATE_STORE_NAME = "order-statestore";

    /** statestoreのkey prefix */
    private static final String KEY_PREFIX = "cart:";

    @Inject
    ObjectMapper objectMapper;

    @Override
    public Response getByCartId(Integer cartId) {
        RestCart result = executeDaprClient(c -> {
            try {
                // 文字列として取得
                State<String> retrievedState = c.getState(STATE_STORE_NAME, createKey(cartId),
                        String.class).block();
                
                if (retrievedState == null || retrievedState.getValue() == null) {
                    return null;
                }
                
                // 文字列をRestCartオブジェクトに変換
                return objectMapper.readValue(retrievedState.getValue(), RestCart.class);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "カートデータの取得中にエラーが発生しました", e);
                throw new RuntimeException(e);
            }
        });
        
        return Response.ok(result).build();
    }

    @Override
    public Response create(@Valid @NotNull RestCart cart) {
        executeDaprClient(c -> {
            try {
                // RestCartオブジェクトをJSON文字列に変換
                String jsonValue = objectMapper.writeValueAsString(cart);
                return c.saveState(STATE_STORE_NAME, createKey(cart.getId()), jsonValue).block();
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "カートデータの保存中にエラーが発生しました", e);
                throw new RuntimeException(e);
            }
        });
        return Response.ok(cart).build();
    }

    @Override
    public Response update(@Valid @NotNull RestCart cart) {
        return create(cart);
    }

    @Override
    public Response deleteByCartId(Integer cartId) {
        executeDaprClient(c -> c.deleteState(STATE_STORE_NAME, createKey(cartId)).block());
        return Response.ok(Status.ACCEPTED).build();
    }

    /**
     * statestoreのキーを作成する。「cart:123456789」
     * @param customerId 顧客Id
     * @return キー
     */
    private String createKey(Integer customerId) {
        return KEY_PREFIX + String.valueOf(customerId);
    }

    private <R> R executeDaprClient(Function<DaprClient, R> func) {
        try (DaprClient client = new DaprClientBuilder().build()) {
            return func.apply(client);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
