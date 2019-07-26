package com.iluwatar.chain;

/**
 * OrcSoldier
 */
public class OrcSoldier extends RequestHandler {

    public OrcSoldier(RequestHandler handler) {
        super(handler);
        System.out.println("OrcSoldier构造函数");
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.COLLECT_TAX)) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
            //陷入死循环
           //handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc soldier";
    }

    public static void main(String[] args) {
        OrcSoldier orcSoldier = new OrcSoldier(new OrcCommander(null));
        System.out.println("orcSoldier.toString()   " + orcSoldier.toString());
    }

}
