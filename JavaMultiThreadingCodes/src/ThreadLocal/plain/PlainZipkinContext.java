
package ThreadLocal.plain;

public class PlainZipkinContext {
    private static final ThreadLocal<PlainZipkinContext> LOCAL = new ThreadLocal<PlainZipkinContext>() {
        private PlainZipkinContext context;

        protected PlainZipkinContext initialValue() {
            context = new PlainZipkinContext();
            return context;
        }
    };
    private String globalTicket;
    private String parentRpcId;
    private String rpcId;
    private String rpcIndex;
    private String rpcEntryUrl;
    private String contextType;

    public PlainZipkinContext() {
    }

    public static PlainZipkinContext getContext() {
        return (PlainZipkinContext) LOCAL.get();
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
