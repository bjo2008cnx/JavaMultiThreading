
package ThreadLocal.inheritable;

public class ZipkinContext {
    private static final InheritableThreadLocal<ZipkinContext> LOCAL = new InheritableThreadLocal<ZipkinContext>() {
        private ZipkinContext context;

        protected ZipkinContext initialValue() {
            context = new ZipkinContext();
            return context;
        }

        @Override
        protected ZipkinContext childValue(ZipkinContext parentValue) {
            return context;
        }

    };
    private String globalTicket;
    private String parentRpcId;
    private String rpcId;
    private String rpcIndex;
    private String rpcEntryUrl;
    private String contextType;

    public ZipkinContext() {
    }

    public static ZipkinContext getContext() {
        return (ZipkinContext) LOCAL.get();
    }

    public static void removeContext() {
        LOCAL.remove();
    }

    public String getGlobalTicket() {
        return this.globalTicket;
    }

    public void setGlobalTicket(String globalTicket) {
        this.globalTicket = globalTicket;
    }

    public String getParentRpcId() {
        return this.parentRpcId;
    }

    public void setParentRpcId(String parentRpcId) {
        this.parentRpcId = parentRpcId;
    }

    public String getRpcId() {
        return this.rpcId;
    }

    public void setRpcId(String rpcId) {
        this.rpcId = rpcId;
    }

    public String getRpcIndex() {
        return this.rpcIndex;
    }

    public void setRpcIndex(String rpcIndex) {
        this.rpcIndex = rpcIndex;
    }

    public String getRpcEntryUrl() {
        return this.rpcEntryUrl;
    }

    public void setRpcEntryUrl(String rpcEntryUrl) {
        this.rpcEntryUrl = rpcEntryUrl;
    }

    public String getContextType() {
        return this.contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }
}
