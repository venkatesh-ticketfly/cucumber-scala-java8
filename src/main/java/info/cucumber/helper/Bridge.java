package info.cucumber.helper;

import cucumber.api.java8.StepdefBody;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Function6;
import scala.Function7;
import scala.Function8;
import scala.Function9;
import scala.Unit;

public class Bridge {

    public static StepdefBody.A0 A0(Function0<Unit> fn) {
        return fn::apply;
    }

    public static <T1> StepdefBody.A1<T1> A1(Function1<T1, Unit> fn) {
        return fn::apply;
    }

    public static <T1, T2> StepdefBody.A2<T1, T2> A2(Function2<T1, T2, Unit> fn) {
        return fn::apply;
    }

    public static <T1, T2, T3> StepdefBody.A3<T1, T2, T3> A3(Function3<T1, T2,T3, Unit> fn) {
        return fn::apply;
    }

    public static <T1, T2, T3, T4> StepdefBody.A4<T1, T2, T3, T4> A4(Function4<T1, T2,T3, T4, Unit> fn) {
        return fn::apply;
    }

    public static <T1, T2, T3, T4, T5> StepdefBody.A5<T1, T2, T3, T4, T5> A5(Function5<T1, T2,T3, T4, T5, Unit> fn) {
        return fn::apply;
    }

    public static <T1, T2, T3, T4, T5, T6> StepdefBody.A6<T1, T2, T3, T4, T5, T6> A6(Function6<T1, T2,T3, T4, T5, T6, Unit> fn) {
        return fn::apply;
    }

    public static <T1, T2, T3, T4, T5, T6, T7> StepdefBody.A7<T1, T2, T3, T4, T5, T6, T7> A7(Function7<T1, T2,T3, T4, T5, T6, T7, Unit> fn) {
        return fn::apply;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> StepdefBody.A8<T1, T2, T3, T4, T5, T6, T7, T8> A8(Function8<T1, T2,T3, T4, T5, T6, T7, T8, Unit> fn) {
        return fn::apply;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> StepdefBody.A9<T1, T2, T3, T4, T5, T6, T7, T8, T9> A9(Function9<T1, T2,T3, T4, T5, T6, T7, T8, T9, Unit> fn) {
        return fn::apply;
    }
}
