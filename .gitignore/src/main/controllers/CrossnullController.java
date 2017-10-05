package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
public class CrossnullController {

    private String[] array;
    private String signUser;
    private String compSign;
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String start() {
        array =  new String[9];
        return "pages/index";
    }

    @RequestMapping(path = "/step", method = RequestMethod.GET)
    public String stepget(HttpServletRequest request) {
        setAttributes(request);
        return "pages/crossnull";
    }

    @RequestMapping(path = "/step", method = RequestMethod.POST)
    public String steppost(HttpServletRequest request) {
        if (signUser == null || signUser.isEmpty()){
            signs(request);
        }
        readParameters(request);
        compStep();
        String winner = checkWin();
        if (winner != null) {
            request.setAttribute("winner", winner);
            return "pages/winnerPage";
        }
        setAttributes(request);
        return "pages/crossnull";
    }


    private String checkWin() {
        if (            line(array[0], array[1], array[2]) != null){
           return array[0];
        }
        if (            line(array[3], array[4], array[5]) != null){
            return array[3];
        }
        if (            line(array[6], array[7], array[8]) != null){
            return array[6];
        }
        if (             line(array[0], array[4], array[8]) != null){
            return array[0];
        }
        if (             line(array[2], array[4], array[6]) != null){
            return array[2];
        }
        if (             line(array[0], array[3], array[6]) != null) {
            return array[0];
        }
        if (           line(array[1], array[4], array[7]) != null){
            return array[1];
        }
        if (           line(array[2], array[5], array[8]) != null) {
            return array[2];
        }
        return null;
    }

    private void signs(HttpServletRequest request) {
        setSignUser(request.getParameter("signUser"));
        if (signUser.equals("x")) {
            compSign = "O";
        } else {
            compSign = "X";
        }
    }

    private void setSignUser(String signUser) {
        this.signUser = signUser;
    }

    private void compStep( ) {

        while (true){
            Random random = new Random();
            int index = random.nextInt(array.length - 1);
            if (array[index] == null) {
                array[index] = compSign;
                break;
            }
        }
    }

    private void setAttributes(HttpServletRequest request) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                request.setAttribute("value" + i, array[i]);
            }
        }
    }

    private void readParameters(HttpServletRequest request) {
        for (Integer i = 0; i < array.length; i++) {
            if (array[i] == null && request.getParameter(i.toString()) != null) {
                String param = request.getParameter(i.toString());
                if (param.equals("X") || param.equals("O")) {
                    array[i] = param;
                }
            }
        }
    }

    private String line(String cell1, String cell2, String cell3) {
        if (cell1 != null && cell2 != null && cell3 != null)
        if (cell1.equals(cell2) && cell2.equals(cell3)) {
            return cell1;
        }
        return null;
    }
}
