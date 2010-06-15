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


import org.apache.chemistry.opencmis.client.bindings.spi.Session;
import org.apache.chemistry.opencmis.commons.data.ExtensionsData;
import org.apache.chemistry.opencmis.commons.server.CmisService;
import org.apache.chemistry.opencmis.commons.server.CmisServiceFactory;
import org.apache.chemistry.opencmis.commons.spi.MultiFilingService;

public class MultiFilingServiceImpl extends AbstractLocalService implements MultiFilingService {

    /**
     * Constructor.
     */
    public MultiFilingServiceImpl(Session session, CmisServiceFactory factory) {
        setSession(session);
        setServiceFactory(factory);
    }

    public void addObjectToFolder(String repositoryId, String objectId, String folderId, Boolean allVersions,
            ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            service.addObjectToFolder(repositoryId, objectId, folderId, allVersions, extension);
        } finally {
            service.close();
        }
    }

    public void removeObjectFromFolder(String repositoryId, String objectId, String folderId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            service.removeObjectFromFolder(repositoryId, objectId, folderId, extension);
        } finally {
            service.close();
        }
    }
}
