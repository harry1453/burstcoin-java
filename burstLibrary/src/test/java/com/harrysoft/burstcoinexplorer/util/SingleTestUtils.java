package com.harrysoft.burstcoinexplorer.util;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static junit.framework.Assert.*;

public class SingleTestUtils {
    public static <T> T testSingle(Single<T> single) {
        assertNotNull(single);
        TestObserver<T> observer = single.test();
        assertTrue(observer.awaitTerminalEvent());
        observer.errors().forEach(Throwable::printStackTrace);
        observer.assertNoErrors();
        T object = observer.values().get(0);
        assertNotNull(object);
        return object;
    }
}
