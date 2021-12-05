package visao.util;

import visao.TelaLog;

public class Logger {
    
    private static TelaLog telaLog;
    
    public static void setTelaLog(TelaLog telaLog) {
        Logger.telaLog = telaLog;
    }
    
    public static void escreverMensagem(String logMsg){
        telaLog.appendTextLogTextArea(logMsg);
        telaLog.appendTextLogTextArea("\n\n");
    }
}
