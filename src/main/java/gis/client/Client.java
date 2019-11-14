package gis.client;

import gis.app.NdsRequest2;
import gis.app.NdsResponse2;
import gis.utils.AnswerParser;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class Client extends WebServiceGatewaySupport {

    public NdsResponse2 getResponse(String inn){
        NdsRequest2 request = new NdsRequest2();
        NdsRequest2.NP np = new NdsRequest2.NP();
        np.setINN(inn);
        request.getNP().add(np);
        NdsResponse2 response = (NdsResponse2)getWebServiceTemplate().marshalSendAndReceive(request,
                new SoapActionCallback("http://npchk.nalog.ru:80/FNSNDSCAWS_2"));
        return response;
    }
    //И т.д. для списков и дат
    public NdsResponse2 getResponse(String inn, String kpp){
        NdsRequest2 request = new NdsRequest2();
        NdsRequest2.NP np = new NdsRequest2.NP();
        np.setINN(inn);
        np.setKPP(kpp);
        request.getNP().add(np);
        NdsResponse2 response = (NdsResponse2)getWebServiceTemplate().marshalSendAndReceive(request,
                new SoapActionCallback("http://npchk.nalog.ru:80/FNSNDSCAWS_2"));
        return response;
    }

    public void printResp(NdsResponse2 resp){
        resp.getNP().forEach(AnswerParser::printState);
    }
}
