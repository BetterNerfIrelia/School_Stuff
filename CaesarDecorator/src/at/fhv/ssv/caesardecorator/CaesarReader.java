package at.fhv.ssv.caesardecorator;


        import java.io.IOException;
        import java.io.Reader;

public class CaesarReader extends Reader{

    private int _offset;
    private Reader _reader;

    /**
     offset und ein reader werden im konstruktor uebergeben.
     */

    public CaesarReader(int offset, Reader reader) {

        _offset = offset % 26;
        _reader = reader;
    }

    /**
     caesar-entschluesselung um angegebenen offset. nicht-buchstaben werden ignoriert.
     */

    private char[] decode(char[] cbuf) {

        for (int i = 0; i < cbuf.length; i++) {

            if ((cbuf[i] >= 'a' && cbuf[i] <= 'z') || (cbuf[i] >= 'A' && cbuf[i] <= 'Z')) {
                cbuf[i] = (char) (cbuf[i] - _offset);

            } else {
                cbuf[i] = cbuf[i];
            }

        }return cbuf;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int charRead = _reader.read(cbuf);
        decode(cbuf);
        return  charRead;
    }

    @Override
    public void close () throws IOException {

    }

}






