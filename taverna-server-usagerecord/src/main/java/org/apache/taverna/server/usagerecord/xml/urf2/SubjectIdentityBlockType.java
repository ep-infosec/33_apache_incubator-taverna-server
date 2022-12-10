/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.04 at 04:15:49 PM GMT 
//


package org.apache.taverna.server.usagerecord.xml.urf2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Open Grid Forum GFD.204 Usage Record type <code>SubjectIdentityBlockType</code>
 * 
 * @see <a href="https://www.ogf.org/documents/GFD.204.pdf#section.4">GFD.204 section 4</a>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubjectIdentityBlockType", propOrder = {
    "localUserId",
    "localGroupId",
    "globalUserId",
    "globalGroupId",
    "globalGroupAttribute"
})
public class SubjectIdentityBlockType {

    @XmlElement(name = "LocalUserId")
    protected String localUserId;
    @XmlElement(name = "LocalGroupId")
    protected String localGroupId;
    @XmlElement(name = "GlobalUserId")
    protected String globalUserId;
    @XmlElement(name = "GlobalGroupId")
    protected String globalGroupId;
    @XmlElement(name = "GlobalGroupAttribute")
    protected List<GlobalGroupAttributeType> globalGroupAttribute;

    /**
     * Gets the value of the localUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalUserId() {
        return localUserId;
    }

    /**
     * Sets the value of the localUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalUserId(String value) {
        this.localUserId = value;
    }

    /**
     * Gets the value of the localGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalGroupId() {
        return localGroupId;
    }

    /**
     * Sets the value of the localGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalGroupId(String value) {
        this.localGroupId = value;
    }

    /**
     * Gets the value of the globalUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalUserId() {
        return globalUserId;
    }

    /**
     * Sets the value of the globalUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalUserId(String value) {
        this.globalUserId = value;
    }

    /**
     * Gets the value of the globalGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalGroupId() {
        return globalGroupId;
    }

    /**
     * Sets the value of the globalGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalGroupId(String value) {
        this.globalGroupId = value;
    }

    /**
     * Gets the value of the globalGroupAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the globalGroupAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlobalGroupAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlobalGroupAttributeType }
     * 
     * 
     */
    public List<GlobalGroupAttributeType> getGlobalGroupAttribute() {
        if (globalGroupAttribute == null) {
            globalGroupAttribute = new ArrayList<GlobalGroupAttributeType>();
        }
        return this.globalGroupAttribute;
    }

}