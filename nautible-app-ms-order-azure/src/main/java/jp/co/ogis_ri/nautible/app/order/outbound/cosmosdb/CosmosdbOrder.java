package jp.co.ogis_ri.nautible.app.order.outbound.cosmosdb;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * 注文ドメイン
 */
@MongoEntity(collection = "Order")
public class CosmosdbOrder {

    /** id */
    @BsonId // メソッドに定義すると有効にならないAPIがある。
    private Integer id = null;
    /**
     * 注文番号。「O0000000001」
     **/
    @BsonProperty("OrderNo") // メソッドに定義すると有効にならないAPIがある。
    private String orderNo;
    /** 顧客Id */
    @BsonProperty("CustomerId")
    private Integer customerId;
    /** 注文日 */
    @BsonProperty("OrderDate")
    private LocalDateTime orderDate;
    /** 注文金額 */
    @BsonProperty("OrderPrice")
    private Integer orderPrice;
    /** 注文状況 */
    @BsonProperty("OrderStatus")
    private CosmosdbOrderStatus orderStatus;
    /** メモ */
    @BsonProperty("Memo")
    private String memo;
    /** 商品 */
    @BsonProperty("Products")
    private List<CosmosdbProduct> products = new ArrayList<>();
    /** 配送 */
    @BsonProperty("Delivery")
    private CosmosdbDelivery delivery;
    /** 支払い */
    @BsonProperty("Payment")
    private CosmosdbPayment payment;

    /**
     * Idを設定する
     * @param id Id
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Idを取得する
     * @return Id
    **/
    public Integer getId() {
        return id;
    }

    /**
     * Idを設定する
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 注文番号を設定する
     * @param orderNo 注文番号
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder orderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    /**
     * 注文番号を取得する
     * @return 注文番号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 注文番号を設定する
     * @param orderNo 注文番号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 顧客Idを設定する
     * @param customerId 顧客Id
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder customerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * 顧客Idを取得する
     * @return 顧客Id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 顧客Idを設定する
     * @param customerId 顧客Id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 注文日を設定する
     * @param orderDate 注文日
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder orderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    /**
     * 注文日を取得する
     * @return 注文日
     */
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    /**
     * 注文日を設定する
     * @param orderDate 注文日
     */
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 注文金額を設定する
     * @param orderPrice 注文金額
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder orderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    /**
     * 注文金額を取得する
     * @return 注文金額
     */
    public Integer getOrderPrice() {
        return orderPrice;
    }

    /**
     * 注文金額を設定する
     * @param orderPrice 注文金額
     */
    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 注文状況を設定する
     * @param orderStatus 注文状況
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder orderStatus(CosmosdbOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    /**
     * 注文状況を取得する
     * @return 注文状況
     */
    public CosmosdbOrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * 注文状況を設定する
     * @param orderStatus 注文状況
     */
    public void setOrderStatus(CosmosdbOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * メモを設定する
     * @param memo メモ
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder memo(String memo) {
        this.memo = memo;
        return this;
    }

    /**
     * メモを取得する
     * @return メモ
     */
    public String getMemo() {
        return memo;
    }

    /**
     * メモを設定する
     * @param memo メモ
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 配送を設定する
     * @param delivery 配送
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder delivery(CosmosdbDelivery delivery) {
        this.delivery = delivery;
        return this;
    }

    /**
     * 配送を取得する
     * @return 配送
     */
    public CosmosdbDelivery getDelivery() {
        return delivery;
    }

    /**
     * 配送を設定する
     * @param delivery 配送
     */
    public void setDelivery(CosmosdbDelivery delivery) {
        this.delivery = delivery;
    }

    /**
     * 支払いを設定する
     * @param payment 支払い
     * @return {@link CosmosdbPayment}
     */
    public CosmosdbOrder payment(CosmosdbPayment payment) {
        this.payment = payment;
        return this;
    }

    /**
     * 支払いを取得する
     * @return 支払い
     */
    public CosmosdbPayment getPayment() {
        return payment;
    }

    /**
     * 支払いを設定する
     * @param payment 支払い
     */
    public void setPayment(CosmosdbPayment payment) {
        this.payment = payment;
    }

    /**
     * 商品を設定する
     * @param products 商品
     * @return {@link CosmosdbOrder}
     */
    public CosmosdbOrder products(List<CosmosdbProduct> products) {
        this.products = products;
        return this;
    }

    /**
     * 商品を取得する
     * @return 商品
     */
    public List<CosmosdbProduct> getProducts() {
        return products;
    }

    /**
     * 商品を設定する
     * @param products 商品
     */
    public void setProducts(List<CosmosdbProduct> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CosmosdbOrder order = (CosmosdbOrder) o;
        return Objects.equals(this.orderNo, order.orderNo) &&
                Objects.equals(this.orderDate, order.orderDate) &&
                Objects.equals(this.orderPrice, order.orderPrice) &&
                Objects.equals(this.orderStatus, order.orderStatus) &&
                Objects.equals(this.products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, orderDate, orderPrice, orderStatus, products);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");

        sb.append("    orderNo: ").append(toIndentedString(orderNo)).append("\n");
        sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
        sb.append("    orderPrice: ").append(toIndentedString(orderPrice)).append("\n");
        sb.append("    orderStatus: ").append(toIndentedString(orderStatus)).append("\n");
        sb.append("    products: ").append(toIndentedString(products)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
