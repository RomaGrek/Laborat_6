package commands;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/** Класс Command-конструктор комманд
 */
public abstract class Command implements CommandDo, Serializable, ValidCommand {
    private String value;

    private String message = "";

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void updateMessage(String message)
    {
        this.message+=message;
    }

    /**
     * Метод реализующий серилизацию команд
     * @return data
     * @throws IOException
     */
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.flush();
        byte[] data = byteArrayOutputStream.toByteArray();
        return data;
    }
}
