package org.apache.chemistry.opencmis.client.bindings.spi.local;
/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */


import java.util.List;

import org.apache.chemistry.opencmis.client.bindings.spi.Session;
import org.apache.chemistry.opencmis.commons.data.ExtensionsData;
import org.apache.chemistry.opencmis.commons.data.ObjectData;
import org.apache.chemistry.opencmis.commons.server.CmisService;
import org.apache.chemistry.opencmis.commons.server.CmisServiceFactory;
import org.apache.chemistry.opencmis.commons.spi.PolicyService;

public class PolicyServiceImpl extends AbstractLocalService implements PolicyService {

    /**
     * Constructor.
     */
    public PolicyServiceImpl(Session session, CmisServiceFactory factory) {
        setSession(session);
        setServiceFactory(factory);
    }

    public void applyPolicy(String repositoryId, String policyId, String objectId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            service.applyPolicy(repositoryId, policyId, objectId, extension);
        } finally {
            service.close();
        }
    }

    public List<ObjectData> getAppliedPolicies(String repositoryId, String objectId, String filter,
            ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getAppliedPolicies(repositoryId, objectId, filter, extension);
        } finally {
            service.close();
        }
    }

    public void removePolicy(String repositoryId, String policyId, String objectId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            service.removePolicy(repositoryId, policyId, objectId, extension);
        } finally {
            service.close();
        }
    }
}
