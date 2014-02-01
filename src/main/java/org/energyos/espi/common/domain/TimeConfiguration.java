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

import org.energyos.espi.common.models.atom.adapters.TimeConfigurationAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Contains attributes related to the configuration of the time service.
 * <p/>
 * <p>Java class for TimeConfiguration complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TimeConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="dstEndRule" type="{http://naesb.org/espi}DstRuleType"/>
 *         &lt;element name="dstOffset" type="{http://naesb.org/espi}TimeType"/>
 *         &lt;element name="dstStartRule" type="{http://naesb.org/espi}DstRuleType"/>
 *         &lt;element name="tzOffset" type="{http://naesb.org/espi}TimeType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeConfiguration", propOrder = {
        "dstEndRule",
        "dstOffset",
        "dstStartRule",
        "tzOffset"
})
@XmlJavaTypeAdapter(TimeConfigurationAdapter.class)
@XmlRootElement(name = "LocalTimeParameters")
@Entity
@Table(name = "time_configurations", uniqueConstraints = {@UniqueConstraint(columnNames={"uuid"})})
@NamedQueries(value = {
        @NamedQuery(name = TimeConfiguration.QUERY_FIND_BY_ID,
                query = "SELECT config FROM TimeConfiguration config WHERE config.id = :id"),
        @NamedQuery(name = TimeConfiguration.QUERY_FIND_BY_UUID,
                query = "SELECT config FROM TimeConfiguration config WHERE config.uuid = :uuid"),
        @NamedQuery(name = TimeConfiguration.QUERY_FIND_ALL_IDS_BY_USAGE_POINT_ID,
                query = "SELECT usagePoint.localTimeParameters.id FROM UsagePoint usagePoint WHERE usagePoint.id = :usagePointId"),
        @NamedQuery(name = TimeConfiguration.QUERY_FIND_ALL_IDS,
                query = "SELECT timeConfiguration.id FROM TimeConfiguration timeConfiguration"),
        @NamedQuery(name = TimeConfiguration.QUERY_FIND_ALL_IDS_BY_XPATH_0, query = "SELECT DISTINCT t.id FROM TimeConfiguration t"),
        @NamedQuery(name = TimeConfiguration.QUERY_FIND_ID_BY_XPATH, query = "SELECT DISTINCT t.id FROM TimeConfiguration t WHERE t.id = :o1Id")

})
public class TimeConfiguration extends IdentifiedObject {

    public static final String QUERY_FIND_BY_ID = "TimeConfiguration.findById";
    public static final String QUERY_FIND_ALL_IDS = "TimeConfiguration.findAllIds";
    public static final String QUERY_FIND_BY_UUID = "TimeConfiguration.findByUUID";
    public static final String QUERY_FIND_ALL_IDS_BY_USAGE_POINT_ID = "TimeConfiguration.findAllIdsByUsagePointId";
    public static final String QUERY_FIND_ALL_IDS_BY_XPATH_0 = "TimeConfiguration.findAllIdsByXpath0";
    public static final String QUERY_FIND_ID_BY_XPATH = "TimeConfiguration.findIdsByXpath";
    
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] dstEndRule;
    protected long dstOffset;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] dstStartRule;
    protected long tzOffset;
    
    @XmlTransient
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "usage_point_id")
    private UsagePoint usagePoint;

    public void setUsagePoint(UsagePoint usagePoint) {
    	this.usagePoint = usagePoint;
    }
    
    public UsagePoint getUsagePoint() {
    	return this.usagePoint;
    }
    
    /**
     * Gets the value of the dstEndRule property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public byte[] getDstEndRule() {
        return dstEndRule;
    }

    /**
     * Sets the value of the dstEndRule property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDstEndRule(byte[] value) {
        this.dstEndRule = value;
    }

    /**
     * Gets the value of the dstOffset property.
     *
     */
    public long getDstOffset() {
        return dstOffset;
    }

    /**
     * Sets the value of the dstOffset property.
     *
     */
    public void setDstOffset(long value) {
        this.dstOffset = value;
    }

    /**
     * Gets the value of the dstStartRule property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public byte[] getDstStartRule() {
        return dstStartRule;
    }

    /**
     * Sets the value of the dstStartRule property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDstStartRule(byte[] value) {
        this.dstStartRule = value;
    }

    /**
     * Gets the value of the tzOffset property.
     *
     */
    public long getTzOffset() {
        return tzOffset;
    }

    /**
     * Sets the value of the tzOffset property.
     *
     */
    public void setTzOffset(long value) {
        this.tzOffset = value;
    }

    @Override
    public String getParentQuery() {
        return UsagePoint.QUERY_FIND_BY_RELATED_HREF;
    }
    
    @Override
    public void merge(IdentifiedObject resource) {
    	super.merge(resource);
    	this.setDstStartRule(((TimeConfiguration)resource).getDstStartRule());
        this.setTzOffset(((TimeConfiguration)resource).getTzOffset());
        this.setDstEndRule(((TimeConfiguration)resource).getDstEndRule());
        this.setDstOffset(((TimeConfiguration)resource).getDstOffset());
    }
}
