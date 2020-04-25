package in.microservice.ordersmicroservice.bean;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@SequenceGenerator(initialValue = 1001, name = "sequenceGeneratorForOrders")
	@GeneratedValue(generator = "sequenceGeneratorForOrders", strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int orderNumber;
	
	@Column(name = "PURCH_AMT")
	private double purchaseAmt;
	/**
	 * order_id and item_id both would be primary key in
	 * the table 'purchased_items' table.
	 */
	@ElementCollection
	@CollectionTable(name = "purchased_items",
		joinColumns = @JoinColumn(name = "order_id"))
	@MapKeyColumn(name = "item_id") //key of map
	@Column(name = "number_of_items") //value of map
	private Map<Integer, Integer> purchasedItemsAndCount;
	
	@Column(name = "ORD_DATE")
	private LocalDateTime dateTime;
	
	@Column(name = "customer_id")
	@JoinTable(name = "customers",
			joinColumns = @JoinColumn(name = "id"))
	private Integer customerId;
	
	@Column(name = "salesman_id")
	@JoinTable(name = "salesman",
		joinColumns = @JoinColumn(name ="id"))
	private Integer salesmanId;

	public Order() {
		
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getPurchaseAmt() {
		return purchaseAmt;
	}

	public void setPurchaseAmt(double purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}

	public Map<Integer, Integer> getPurchasedItemsAndCount() {
		return purchasedItemsAndCount;
	}

	public void setPurchasedItemsAndCount(Map<Integer, Integer> purchasedItemsAndCount) {
		this.purchasedItemsAndCount = purchasedItemsAndCount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + orderNumber;
		long temp;
		temp = Double.doubleToLongBits(purchaseAmt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((purchasedItemsAndCount == null) ? 0 : purchasedItemsAndCount.hashCode());
		result = prime * result + ((salesmanId == null) ? 0 : salesmanId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (Double.doubleToLongBits(purchaseAmt) != Double.doubleToLongBits(other.purchaseAmt))
			return false;
		if (purchasedItemsAndCount == null) {
			if (other.purchasedItemsAndCount != null)
				return false;
		} else if (!purchasedItemsAndCount.equals(other.purchasedItemsAndCount))
			return false;
		if (salesmanId == null) {
			if (other.salesmanId != null)
				return false;
		} else if (!salesmanId.equals(other.salesmanId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", purchaseAmt=" + purchaseAmt + ", purchasedItemsAndCount="
				+ purchasedItemsAndCount + ", dateTime=" + dateTime + ", customerId=" + customerId + ", salesmanId="
				+ salesmanId + "]";
	}
}
