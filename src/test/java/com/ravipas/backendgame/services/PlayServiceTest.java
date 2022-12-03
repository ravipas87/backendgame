package com.ravipas.backendgame.services;

import com.ravipas.backendgame.models.PlayOption;
import com.ravipas.backendgame.models.PlayResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PlayServiceTest {

    @InjectMocks
    PlayService playService;

    @Test
    public void gameLogicTest() {
        // test all posible outcomes

        try {
            assertEquals(PlayResult.TIE, getEvaluatePlay().invoke(playService, new PlayOption[]{PlayOption.ROCK, PlayOption.ROCK}));

        assertEquals(PlayResult.WIN, getEvaluatePlay().invoke(playService,new PlayOption[] {PlayOption.ROCK,PlayOption.PAPER}));
        assertEquals(PlayResult.LOSE, getEvaluatePlay().invoke(playService,new PlayOption[] {PlayOption.ROCK,PlayOption.SCISSORS}));

        assertEquals(PlayResult.LOSE, getEvaluatePlay().invoke(playService,new PlayOption[] {PlayOption.PAPER,PlayOption.ROCK}));
        assertEquals(PlayResult.TIE, getEvaluatePlay().invoke(playService,new PlayOption[] {PlayOption.PAPER,PlayOption.PAPER}));
        assertEquals(PlayResult.WIN, getEvaluatePlay().invoke(playService,new PlayOption[] {PlayOption.PAPER,PlayOption.SCISSORS}));

        assertEquals(PlayResult.WIN, getEvaluatePlay().invoke(playService,new PlayOption[] {PlayOption.SCISSORS,PlayOption.ROCK}));
        assertEquals(PlayResult.LOSE, getEvaluatePlay().invoke(playService,new PlayOption[] {PlayOption.SCISSORS,PlayOption.PAPER}));

        assertEquals(PlayResult.TIE, getEvaluatePlay().invoke(playService,new PlayOption[] {PlayOption.SCISSORS, PlayOption.SCISSORS}));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
    // messing with accessibility level in a test is highly discorauged but I want to test this internal behaviour
    // since the service is interface has randomized behaviour i cannot predict and hence tests
    // the main problem is if we change the method member name and forget to update in test, but a t least we will find it when executing test
    // and ideally not in runtime when app is deployed
    private Method getEvaluatePlay() throws NoSuchMethodException {
        Method method = PlayService.class.getDeclaredMethod("evaluatePlay", PlayOption.class,PlayOption.class);
        method.setAccessible(true);
        return method;
    }

}
