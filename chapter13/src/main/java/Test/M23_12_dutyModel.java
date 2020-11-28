package Test;

public class M23_12_dutyModel {
    public static void main(String[] args) {
        RequestHandler_1081 request1081 = new RequestHandler_1081();
        RequestHandler_1241 request1241 = new RequestHandler_1241(request1081);
        RequestHandler_1251 request1251 = new RequestHandler_1251(request1241);
        RequestHandler_1261 request1261 = new RequestHandler_1261(request1251);
        request1261.dealRequest("1091");
    }
}

interface RequestHandler{
    public void dealRequest(String transferType);
}


class RequestHandler_1081  implements  RequestHandler{
    @Override
    public void dealRequest(String transferType) {
        if("1081".equals(transferType)){
            System.out.println("pcms处理1081报文");
        }else{
            System.out.println("pcms无法处理其他类型的报文");
        }
    }
}

class RequestHandler_1241 implements  RequestHandler{
    private RequestHandler handler = null;
    public RequestHandler_1241(RequestHandler handler){
        this.handler = handler;
    }
    @Override
    public void dealRequest(String transferType) {
        if("1241".equals(transferType)){
            System.out.println("pcms处理1241报文");
        }else{
            handler.dealRequest(transferType);
        }
    }
}

class RequestHandler_1251 implements  RequestHandler{
    private RequestHandler handler = null;
    public RequestHandler_1251(RequestHandler handler){
        this.handler = handler;
    }
    @Override
    public void dealRequest(String transferType) {
        if("1241".equals(transferType)){
            System.out.println("pcms处理1251报文");
        }else{
            handler.dealRequest(transferType);
        }
    }
}

class RequestHandler_1261 implements  RequestHandler{
    private RequestHandler handler = null;
    public RequestHandler_1261(RequestHandler handler){
        this.handler = handler;
    }
    @Override
    public void dealRequest(String transferType) {
        if("1241".equals(transferType)){
            System.out.println("pcms处理1261报文");
        }else{
            handler.dealRequest(transferType);
        }
    }
}