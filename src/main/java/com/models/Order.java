package com.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String orderId;

	private boolean confirmed;

	@OneToMany(
	        mappedBy = "order",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private Set<Item> orderItems;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	protected Order() {
		
	}
	public Order(String orderId, boolean confirmed) {
		super();
		this.orderId = orderId;
		this.confirmed = confirmed;
		this.orderItems = new HashSet<Item>();
	}
	public void addItem(Item i) {
		this.orderItems.add(i);
		i.setOrder(this);
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<Item> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

}
