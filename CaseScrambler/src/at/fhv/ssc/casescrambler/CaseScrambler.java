package at.fhv.ssc.casescrambler;

/**
 * Created by sebastian on 03.09.2017.
 */

import java.io.IOException;
import java.io.Reader;

/**
 * Filter based on decorator-pattern, which alternating scrambles text-input between lower- and upper-case.
 * (first letter always set as lower-case, scrambles letters only)
 */

public class CaseScrambler extends Reader{

    private Reader _reader;

    public CaseScrambler(Reader reader){

        _reader = reader;

    }


    public char[] scrambler(char [] cbuf) {
        int counter = 0;
        for (int i = 0; i < cbuf.length; i++) {
            if (counter % 2 == 0) {

                if (cbuf[i] >= 'a' && cbuf[i] <= 'z') {
                    cbuf[i] = (cbuf[i]);
                    counter++;
                } else if (cbuf[i] >= 'A' && cbuf[i] <= 'Z') {
                    cbuf[i] = (char) (cbuf[i] + 32);
                    counter++;
                }

            } else if (counter % 2 != 0) {
                if (cbuf[i] >= 'A' && cbuf[i] <= 'Z') {
                    cbuf[i] = (cbuf[i]);
                    counter++;
                } else if (cbuf[i] >= 'a' && cbuf[i] <= 'z') {
                    cbuf[i] = (char) (cbuf[i] - 32);
                    counter++;
                }
            }
        }return cbuf;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {

        int charRead = _reader.read(cbuf, off, len);
        scrambler(cbuf);
        return  charRead;

    }

    @Override
    public void close() throws IOException {

    }

    public Reader getReader() {
        return _reader;
    }
}
