/*
 * *** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is part of dcm4che, an implementation of DICOM(TM) in
 * Java(TM), hosted at https://github.com/dcm4che.
 *
 * The Initial Developer of the Original Code is
 * J4Care.
 * Portions created by the Initial Developer are Copyright (C) 2013-2021
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 * See @authors listed below
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * *** END LICENSE BLOCK *****
 */

package org.dcm4chee.arc.entity;

/**
 * @author Gunter Zeilinger (gunterze@protonmail.com)
 * @since Aug 2022
 */

import javax.persistence.*;
import java.util.Date;

@NamedQuery(
        name = KeyValue.FIND_BY_KEY_AS_USER,
        query = "select kv from KeyValue kv where kv.key = ?1 and kv.user = ?2")
@NamedQuery(
        name = KeyValue.VALUE_BY_KEY_AS_USER,
        query = "select kv.value from KeyValue kv where kv.key = ?1 and kv.user = ?2")
@NamedQuery(
        name = KeyValue.DELETE_UPDATED_BEFORE,
        query = "delete from KeyValue kv where kv.updatedTime < ?2")
@Entity
@Table(name = "key_value",
        uniqueConstraints = @UniqueConstraint(columnNames = { "key", "user" }),
        indexes = {
                @Index(columnList = "updated_time"),
        })
public class KeyValue {
    public static final String FIND_BY_KEY_AS_USER = "KeyValue.FindByKeyAsUser";
    public static final String VALUE_BY_KEY_AS_USER = "KeyValue.ValueByKeyAsUser";
    public static final String DELETE_UPDATED_BEFORE = "KeyValue.DeleteUpdatedBefore";
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "pk")
    private long pk;

    @Basic(optional = false)
    @Column(name = "created_time", updatable = false)
    private Date createdTime;

    @Basic(optional = false)
    @Column(name = "updated_time")
    private Date updatedTime;

    @Basic(optional = false)
    @Column(name = "user", updatable = false)
    private String user;

    @Basic(optional = false)
    @Column(name = "key", updatable = false)
    private String key;

    @Basic(optional = false)
    @Column(name = "content_type")
    private String contentType;

    @Basic(optional = false)
    @Column(name = "value", length = 4000)
    private String value;

    public long getPk() {
        return pk;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public String getUser() {
        return user;
    }

    public String getKey() {
        return key;
    }

    public String getContentType() {
        return contentType;
    }

    public String getValue() {
        return value;
    }

    public void setKeyAsUser(String key, String user) {
        this.key = key;
        this.user = user;
    }

    public void setValueWithContentType(String value, String contentType) {
        this.value = value;
        this.contentType = contentType;
    }

    @PrePersist
    public void onPrePersist() {
        Date now = new Date();
        createdTime = now;
        updatedTime = now;
    }

    @PreUpdate
    public void onPreUpdate() {
        updatedTime = new Date();
    }
}