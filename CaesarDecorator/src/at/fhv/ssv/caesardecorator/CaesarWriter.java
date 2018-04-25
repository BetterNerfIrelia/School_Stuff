package at.fhv.ssv.caesardecorator;

import java.io.IOException;
import java.io.Writer;

public class CaesarWriter extends Writer {

    private int _offset;
    private Writer _writer;

    /**
     offset und ein reader werden im konstruktor uebergeben.
     */

    public CaesarWriter(int offset, Writer writer) {

        _offset = offset % 26;
        _writer = writer;
    }

    /**
     caesar-verschluesselung um angegebenen offset. nicht-buchstaben werden ignoriert.
     */


    private char[] encode(char[] cbuf) {

        for (int i = 0; i < cbuf.length; i++) {

            if ((cbuf[i] >= 'a' && cbuf[i] <= 'z') || (cbuf[i] >= 'A' && cbuf[i] <= 'Z')) {
                cbuf[i] = (char) (cbuf[i] + _offset);

            } else {
                cbuf[i] = cbuf[i];
            }

        }return cbuf;
    }

        @Override
        public void write (char[] cbuf, int off, int len) throws IOException {
            _writer.write(encode(cbuf));
        }

        @Override
        public void flush () throws IOException {

        }

        @Override
        public void close () throws IOException {

        }

    }





