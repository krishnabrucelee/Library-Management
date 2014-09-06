/*
 * Copyright 2014 sony.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.woorea.openstack.nova;

import com.woorea.openstack.nova.api.ExtensionsResource;
import com.woorea.openstack.nova.api.FlavorsResource;
import com.woorea.openstack.nova.api.ImagesResource;
import com.woorea.openstack.nova.api.QuotaSetsResource;
import com.woorea.openstack.nova.api.ServersResource;
import com.woorea.openstack.nova.api.extensions.AggregatesExtension;
import com.woorea.openstack.nova.api.extensions.FloatingIpsExtension;
import com.woorea.openstack.nova.api.extensions.HostsExtension;
import com.woorea.openstack.nova.api.extensions.KeyPairsExtension;
import com.woorea.openstack.nova.api.extensions.SecurityGroupsExtension;
import com.woorea.openstack.nova.api.extensions.SnapshotsExtension;
import com.woorea.openstack.nova.api.extensions.VolumesExtension;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sony
 */
public class NovaTest {
    
    public NovaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of extensions method, of class Nova.
     */
    @Test
    public void testExtensions() {
        System.out.println("extensions");
        Nova instance = null;
        ExtensionsResource expResult = null;
        ExtensionsResource result = instance.extensions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of servers method, of class Nova.
     */
    @Test
    public void testServers() {
        System.out.println("servers");
        Nova instance = null;
        ServersResource expResult = null;
        ServersResource result = instance.servers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of images method, of class Nova.
     */
    @Test
    public void testImages() {
        System.out.println("images");
        Nova instance = null;
        ImagesResource expResult = null;
        ImagesResource result = instance.images();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of flavors method, of class Nova.
     */
    @Test
    public void testFlavors() {
        System.out.println("flavors");
        Nova instance = null;
        FlavorsResource expResult = null;
        FlavorsResource result = instance.flavors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of keyPairs method, of class Nova.
     */
    @Test
    public void testKeyPairs() {
        System.out.println("keyPairs");
        Nova instance = null;
        KeyPairsExtension expResult = null;
        KeyPairsExtension result = instance.keyPairs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of floatingIps method, of class Nova.
     */
    @Test
    public void testFloatingIps() {
        System.out.println("floatingIps");
        Nova instance = null;
        FloatingIpsExtension expResult = null;
        FloatingIpsExtension result = instance.floatingIps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of securityGroups method, of class Nova.
     */
    @Test
    public void testSecurityGroups() {
        System.out.println("securityGroups");
        Nova instance = null;
        SecurityGroupsExtension expResult = null;
        SecurityGroupsExtension result = instance.securityGroups();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of snapshots method, of class Nova.
     */
    @Test
    public void testSnapshots() {
        System.out.println("snapshots");
        Nova instance = null;
        SnapshotsExtension expResult = null;
        SnapshotsExtension result = instance.snapshots();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of volumes method, of class Nova.
     */
    @Test
    public void testVolumes() {
        System.out.println("volumes");
        Nova instance = null;
        VolumesExtension expResult = null;
        VolumesExtension result = instance.volumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of aggregates method, of class Nova.
     */
    @Test
    public void testAggregates() {
        System.out.println("aggregates");
        Nova instance = null;
        AggregatesExtension expResult = null;
        AggregatesExtension result = instance.aggregates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of quotaSets method, of class Nova.
     */
    @Test
    public void testQuotaSets() {
        System.out.println("quotaSets");
        Nova instance = null;
        QuotaSetsResource expResult = null;
        QuotaSetsResource result = instance.quotaSets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of hosts method, of class Nova.
     */
    @Test
    public void testHosts() {
        System.out.println("hosts");
        Nova instance = null;
        HostsExtension expResult = null;
        HostsExtension result = instance.hosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
