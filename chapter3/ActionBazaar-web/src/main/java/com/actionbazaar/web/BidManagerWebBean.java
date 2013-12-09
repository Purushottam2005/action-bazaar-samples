/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.actionbazaar.web;

import com.actionbazaar.buslogic.BidManager;
import com.actionbazaar.persistence.Bid;
import com.actionbazaar.persistence.Bidder;
import com.actionbazaar.persistence.Item;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bid Manager - handles the add bid form.
 */
@ManagedBean
@ViewScoped
public class BidManagerWebBean {

    @EJB
    private BidManager bidManager;

    //@EJB
    private Bidder user;

    @Inject
    private Item item;
    private Bid bid = new Bid();

    //@Produces
    //@Named
    //@RequestScoped
    //public Bid getBid() {
    //    return bid;
    //}

    private Double amount;
    
    

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String placeBid() {
        bid.setBidPrice(amount);
        bid.setBidder(user);
        bid.setItem(item);
        bidManager.addBid(bid);
        // Incomplete bidService.addBid(bid);
        return "bid_confirm.xhtml";
    }
    
    public String getHelloWorld() {
        return "Hello world!";
    }
}
