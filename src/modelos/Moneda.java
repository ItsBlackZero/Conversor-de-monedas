package modelos;

import com.google.gson.annotations.SerializedName;

public class Moneda {
    @SerializedName("conversion_rate")
    private float valorConvertido;

    public Moneda() {
    }

    public Moneda(float valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public float getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(float valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "valorConvertido=" + valorConvertido +
                '}';
    }
}
