package com.krishna.cloudstackrootadminapi.x;

/**
 * List Cluster Response from demo.fogpanel.com/client
 *
 * @author Krishna <krishna.it2329@gmail.com>
 */
class ListClusters {

    /**
     * The cluster ID
     */
    private String id;
    /**
     * The allocation state of the cluster
     */
    private String allocationState;
    /**
     * The type of the cluster
     */
    private String clusterType;
    /**
     * The cpu overcommit ratio of the cluster
     */
    private String cpuOverCommitRatio;
    /**
     * The hypervisor type of the cluster
     */
    private String hypervisorType;
    /**
     * whether this cluster is managed by cloudstack
     */
    private String managedState;
    /**
     * The memory overcommit ratio of the cluster
     */
    private String memoryOverCommitRatio;
    /**
     * The cluster name
     */
    private String name;
    /**
     * The Pod ID of the cluster
     */
    private String podId;
    /**
     * The Pod name of the cluster
     */
    private String podName;
    /**
     * The Zone ID of the cluster
     */
    private String zoneId;
    /**
     * The Zone name of the cluster
     */
    private String zoneName;

    /**
     *
     * @param id
     * @param name
     * @param podid
     * @param podname
     * @param zoneid
     * @param zonename
     * @param hypervisorType
     * @param clusterType
     * @param allocationState
     * @param managedState
     * @param cpuOverCommitRatio
     * @param memoryOverCommitRatio
     */
    public ListClusters(String id, String name, String podid, String podname, String zoneid, String zonename, String hypervisorType, String clusterType, String allocationState, String managedState, String cpuOverCommitRatio, String memoryOverCommitRatio) {
        this.id = id;
        this.name = name;
        this.podId = podid;
        this.zoneId = zoneid;
        this.zoneName = zonename;
        this.hypervisorType = hypervisorType;
        this.clusterType = clusterType;
        this.allocationState = allocationState;
        this.managedState = managedState;
        this.cpuOverCommitRatio = cpuOverCommitRatio;
        this.memoryOverCommitRatio = memoryOverCommitRatio;
    }

    /**
     * Providing Getter method to get all element values
     *
     * @return Element values
     */
    public String getId() {
        return id;
    }

    public String getAllocationState() {
        return allocationState;
    }

    public String getClusterType() {
        return clusterType;
    }

    public String getCpuOverCommitRatio() {
        return cpuOverCommitRatio;
    }

    public String getHypervisorType() {
        return hypervisorType;
    }

    public String getManagedState() {
        return managedState;
    }

    public String getMemoryOverCommitRatio() {
        return memoryOverCommitRatio;
    }

    public String getName() {
        return name;
    }

    public String getPodId() {
        return podId;
    }

    public String getPodName() {
        return podName;
    }

    public String getZoneId() {
        return zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

}
