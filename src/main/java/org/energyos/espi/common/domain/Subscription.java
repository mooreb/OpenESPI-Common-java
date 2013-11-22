/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.27 at 01:43:57 PM EDT 
//


package org.energyos.espi.common.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;
import java.util.Set;

/**
 * Defines the parameters of a subscription between Third Party and Data Custodian.
 * <p/>
 * <p>Java class for Subscription complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Subscription">
 *   &lt;complexContent>
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscription")
@Entity
@Table(name = "subscriptions")
@NamedQueries(value = {
        @NamedQuery(name = Subscription.QUERY_FIND_ALL, query = "SELECT subscription FROM Subscription subscription"),
        @NamedQuery(name = Subscription.QUERY_FIND_BY_HASHED_ID, query = "SELECT subscription FROM Subscription subscription WHERE subscription.hashedId = :hashedId")
})
public class Subscription
        extends IdentifiedObject {

    public final static String QUERY_FIND_ALL = "Subscription.findAll";
    public final static String QUERY_FIND_BY_HASHED_ID = "Subscription.findByHashedID";

    private String hashedId;

    @ManyToOne
    @JoinColumn(name = "retail_customer_id")
    @NotNull
    @XmlTransient
    protected RetailCustomer retailCustomer;

    @OneToOne
    private Authorization authorization;

    @OneToOne
    @NotNull
    private ApplicationInformation applicationInformation;

    @XmlTransient
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<UsagePoint> usagePoints;

    public Calendar lastUpdate;

    public String getHashedId() {
        return hashedId;
    }

    public void setHashedId(String hashedId) {
        this.hashedId = hashedId;
    }

    public RetailCustomer getRetailCustomer() {
        return retailCustomer;
    }

    public void setRetailCustomer(RetailCustomer retailCustomer) {
        this.retailCustomer = retailCustomer;
    }

    public ApplicationInformation getApplicationInformation() {
        return applicationInformation;
    }

    public void setApplicationInformation(ApplicationInformation applicationInformation) {
        this.applicationInformation = applicationInformation;
    }

    public void setLastUpdate(Calendar lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Calendar getLastUpdate() {
        return lastUpdate;
    }

    public Set<UsagePoint> getUsagePoints() {
        return usagePoints;
    }

    public void setUsagePoints(Set<UsagePoint> usagePoints) {
        this.usagePoints = usagePoints;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
}
