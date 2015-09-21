package br.com.delogic.jfunk.data;

import org.junit.Assert;
import org.junit.Test;

public class SuccessTest extends Assert {

    private String message;
    private Success<? extends Object> success;

    @Test
    public void shouldCreateSucessVoid() {
        givenMessage("Usuário criado com sucesso");
        whenCreatingSuccess();
        thenSuccessHasMessage("Usuário criado com sucesso");
        thenSuccessHasValue(null);
    }

    private void thenSuccessHasMessage(String string) {
        assertEquals(string, success.getMessage());
    }

    private void givenMessage(String string) {
        message = string;
    }

    private void whenCreatingSuccess() {
        success = Success.of(message);
    }

    private void thenSuccessHasValue(Object object) {
        assertEquals(object, success.getValue());
    }

    @Test
    public void shouldCreateSucessWithValue() {
        givenMessage("Teste");
        whenCreatingSuccessWithValue(15);
        thenSuccessHasMessage("Teste");
        thenSuccessHasValue(15);
    }

    private void whenCreatingSuccessWithValue(Integer i) {
        success = Success.of(message, i);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateSucessWithNullValue() {
        givenMessage("Teste");
        whenCreatingSuccessWithValue(null);
    }

}
