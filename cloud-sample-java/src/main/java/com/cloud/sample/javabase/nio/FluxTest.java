package com.cloud.sample.javabase.nio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FluxTest
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/1/7 17:05
 */
public class FluxTest {

    private static List<String> words = Arrays.asList(
            "the","quick","brown","fox","jumped","over","the","lazy","dog"
    );
    public static void main(String[] args) {
        Flux.fromIterable(words).flatMap(word->Flux.fromArray(word.split("")))
                .concatWith(Mono.just("s")).distinct().sort()
                .zipWith(Flux.range(1,Integer.MAX_VALUE),(string,count)->String.format("%2d. %s",count,string))
                .subscribe(System.out::println);
    }
}
