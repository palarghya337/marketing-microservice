package in.microservice.ordersmicroservice.bean;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@SequenceGenerator(initialValue = 1001, name = "sequenceGeneratorForOrders")
	@GeneratedValue(generator = "sequenceGeneratorForOrders", strategy = GenerationType.IDENTITY)
	@Column(name = "ORD_NO")
	private int orderNumber;
	
	@Column(name = "PURCH_AMT")
	private double purchaseAmt;
	
	@Column(name = "ORD_DATE")
	private LocalDateTime dateTime;
	
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;
	
	@Column(name = "SALESMAN_ID")
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

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + orderNumber;
		long temp;
		temp = Double.doubleToLongBits(purchaseAmt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + salesmanId;
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
		if (customerId != other.customerId)
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
		if (salesmanId != other.salesmanId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [orderNumber=" + orderNumber + ", purchaseAmt=" + purchaseAmt + ", dateTime=" + dateTime
				+ ", customerId=" + customerId + ", salesmanId=" + salesmanId + "]";
	}
}
