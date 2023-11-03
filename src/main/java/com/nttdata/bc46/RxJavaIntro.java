package com.nttdata.bc46;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxJavaIntro {

    public static void main(String[] args) {
        Observable<String> obString = Observable.just("jimmy", "julio", "marcos", "maria");

        Observer<String> observador = new Observer<String>() {

            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Se suscribio");
            }

            public void onNext(@NonNull String s) {
                System.out.println("dato: " + s);
            }

            public void onError(@NonNull Throwable e) {
                System.out.println("excepcion: " + e.getMessage());
            }

            public void onComplete() {
                System.out.println("finalizo");
            }
        };
        obString.filter(x -> x.startsWith("m")).subscribe(
                x -> System.out.println(x.toUpperCase())
        );
        obString.subscribe(observador);

        String[] nombres = {"Ana", "Juan", "alberto", null, "Carlos"};

        // Crear un flujo Observable a partir de la lista de nombres
        Observable<String> nombresObservable = Observable.fromArray(nombres);

        // Filtrar los nombres cuyas iniciales comienzan con "A"
        nombresObservable
                .map(d->d.toUpperCase())
                .filter(nombre -> nombre.startsWith("A"))
                .subscribe(
                        nombre -> System.out.println("Nombre que empieza con 'A': " + nombre),
                        error -> System.err.println("Error: " + error),
                        () -> System.out.println("Proceso completado")
                );

    }
    
}
