package info.cucumber.scala

import java.lang.reflect.Type
import java.util.Locale

import cucumber.api.{Scenario, DataTable}
import cucumber.api.java8.{HookBody, HookNoArgsBody, GlueBase, StepdefBody}
import cucumber.runtime.java.{JavaBackend, TypeIntrospector}
import cucumber.runtime.java8.LambdaGlueBase
import cucumber.runtime.table.TableConverter
import cucumber.runtime.xstream.LocalizedXStreams
import cucumber.runtime.{Timeout, ParameterInfo, Utils}
import info.cucumber.helper.Bridge

import scala.collection.JavaConversions._
import scala.concurrent.duration.Duration

trait ScalaDsl extends GlueBase {

  def Before(tags: Seq[String]=Seq(), timeout: Duration=Duration.Zero, order: Int=0)(f: Scenario => Unit): Unit = {
    JavaBackend.INSTANCE.get.addBeforeHookDefinition(tags.toArray, timeout.toMillis, order, new HookBody {
      override def accept(scenario: Scenario): Unit = f(scenario)
    })
  }

  def After(tags: Seq[String]=Seq(), timeout: Duration=Duration.Zero, order: Int=0)(f: Scenario => Unit): Unit = {
    JavaBackend.INSTANCE.get.addAfterHookDefinition(tags.toArray, timeout.toMillis, order, new HookBody {
      override def accept(scenario: Scenario): Unit = f(scenario)
    })
  }

  final class Step {
    def apply(regex: String, timeout: Duration = Duration.Zero): StepBody  = new StepBody(regex, timeout)
  }

  final class StepBody(regexp: String, timeout: Duration) {

    import ScalaJava8TypeBridge._

    def apply(f: () => Unit) = register(regexp, timeout, Bridge.A0(f))

    def apply[T1](f: (T1) => Unit) = {
      val converterFn = (t1: T1) => For(f, t1) convert {
        case List(a1: AnyRef) => f(a1.asInstanceOf[T1])
      }

      register(regexp, timeout, Bridge.A1[T1](converterFn))
    }

    def apply[T1, T2](f: (T1, T2) => Unit) = {
      val converterFn = (t1: T1, t2: T2) => For(f, t1, t2) convert {
        case List(a1: AnyRef, a2: AnyRef) => f(a1.asInstanceOf[T1], a2.asInstanceOf[T2])
      }
      register(regexp, timeout, Bridge.A2[T1, T2](converterFn))
    }

    def apply[T1, T2, T3](f: (T1, T2, T3) => Unit) = {
      val converterFn = (t1: T1, t2: T2, t3: T3) => For(f, t1, t2, t3) convert {
        case List(a1: AnyRef, a2: AnyRef, a3: AnyRef) =>
          f(a1.asInstanceOf[T1], a2.asInstanceOf[T2], a3.asInstanceOf[T3])
      }
      register(regexp, timeout, Bridge.A3[T1, T2, T3](converterFn))
    }

    def apply[T1, T2, T3, T4](f: (T1, T2, T3, T4) => Unit) = {
      val converterFn = (t1: T1, t2: T2, t3: T3, t4: T4) => For(f, t1, t2, t3, t4) convert {
        case List(a1: AnyRef, a2: AnyRef, a3: AnyRef, a4: AnyRef) =>
          f(a1.asInstanceOf[T1], a2.asInstanceOf[T2], a3.asInstanceOf[T3], a4.asInstanceOf[T4])
      }
      register(regexp, timeout, Bridge.A4[T1, T2, T3, T4](converterFn))
    }

    def apply[T1, T2, T3, T4, T5](f: (T1, T2, T3, T4, T5) => Unit) = {
      val converterFn = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5) => For(f, t1, t2, t3, t4, t5) convert {
        case List(a1: AnyRef, a2: AnyRef, a3: AnyRef, a4: AnyRef, a5: AnyRef) =>
          f(a1.asInstanceOf[T1], a2.asInstanceOf[T2], a3.asInstanceOf[T3], a4.asInstanceOf[T4], a5.asInstanceOf[T5])
      }
      register(regexp, timeout, Bridge.A5[T1, T2, T3, T4, T5](converterFn))
    }

    def apply[T1, T2, T3, T4, T5, T6](f: (T1, T2, T3, T4, T5, T6) => Unit) = {
      val converterFn = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6) => For(f, t1, t2, t3, t4, t5, t6) convert {
        case List(a1: AnyRef, a2: AnyRef, a3: AnyRef, a4: AnyRef, a5: AnyRef, a6: AnyRef) =>
          f(a1.asInstanceOf[T1], a2.asInstanceOf[T2], a3.asInstanceOf[T3], a4.asInstanceOf[T4], a5.asInstanceOf[T5],
            a6.asInstanceOf[T6])
      }
      register(regexp, timeout, Bridge.A6[T1, T2, T3, T4, T5, T6](converterFn))
    }

    def apply[T1, T2, T3, T4, T5, T6, T7](f: (T1, T2, T3, T4, T5, T6, T7) => Unit) = {
      val converterFn = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7) =>
        For(f, t1, t2, t3, t4, t5, t6, t7) convert {
          case List(a1: AnyRef, a2: AnyRef, a3: AnyRef, a4: AnyRef, a5: AnyRef, a6: AnyRef, a7: AnyRef) =>
           f(a1.asInstanceOf[T1], a2.asInstanceOf[T2], a3.asInstanceOf[T3], a4.asInstanceOf[T4], a5.asInstanceOf[T5],
             a6.asInstanceOf[T6], a7.asInstanceOf[T7])
      }
      register(regexp, timeout, Bridge.A7[T1, T2, T3, T4, T5, T6, T7](converterFn))
    }

    def apply[T1, T2, T3, T4, T5, T6, T7, T8](f: (T1, T2, T3, T4, T5, T6, T7, T8) => Unit) = {
      val converterFn = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8) =>
        For(f, t1, t2, t3, t4, t5, t6, t7, t8) convert {
          case List(a1: AnyRef, a2: AnyRef, a3: AnyRef, a4: AnyRef, a5: AnyRef, a6: AnyRef, a7: AnyRef, a8: AnyRef) =>
            f(a1.asInstanceOf[T1], a2.asInstanceOf[T2], a3.asInstanceOf[T3], a4.asInstanceOf[T4], a5.asInstanceOf[T5],
              a6.asInstanceOf[T6], a7.asInstanceOf[T7], a8.asInstanceOf[T8])
        }
      register(regexp, timeout, Bridge.A8[T1, T2, T3, T4, T5, T6, T7, T8](converterFn))
    }

    def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9) => Unit) = {
      val converterFn = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9) =>
        For(f, t1, t2, t3, t4, t5, t6, t7, t8, t9) convert {
          case List(a1: AnyRef, a2: AnyRef, a3: AnyRef, a4: AnyRef, a5: AnyRef, a6: AnyRef, a7: AnyRef, a8: AnyRef,
            a9: AnyRef) => f(a1.asInstanceOf[T1], a2.asInstanceOf[T2], a3.asInstanceOf[T3], a4.asInstanceOf[T4],
              a5.asInstanceOf[T5], a6.asInstanceOf[T6], a7.asInstanceOf[T7], a8.asInstanceOf[T8], a9.asInstanceOf[T9])
        }
      register(regexp, timeout, Bridge.A9[T1, T2, T3, T4, T5, T6, T7, T8, T9](converterFn))
    }
  }

  private object ScalaJava8TypeBridge {

    val xstream = new LocalizedXStreams(classOf[Utils].getClassLoader).get(Locale.ENGLISH)

    case class For(f: Any, values: Any*) {

      def convert(pf: PartialFunction[List[AnyRef], Unit]): Unit = {
        val convertedValues = ParameterInfo
          .fromTypes(functionParams(f.getClass, "apply")).toList
          .zip(values)
          .map { case(paramInfo, value) =>
            if (value.getClass.isAssignableFrom(classOf[DataTable])) {
              new TableConverter(xstream, paramInfo).convert(value.asInstanceOf[DataTable], paramInfo.getType, false)
            } else {
              paramInfo.convert(value.asInstanceOf[String], xstream)
            }
          }

        pf(convertedValues)
      }
    }

    def register(regexp: String, timeout: Duration, stepdefBody: StepdefBody) =
      JavaBackend.INSTANCE.get.addStepDefinition(regexp, timeout.toMillis, stepdefBody, introspector)

    private def functionParams(clazz: Class[_], methodName: String) = clazz.getDeclaredMethods
      .find(m => methodName.equals(m.getName) && !m.isBridge)
      .map(_.getGenericParameterTypes)
      .getOrElse(throw new IllegalStateException(
        s"Expected single 'accept' method on body class, found ${clazz.getDeclaredMethods}"))

    private val introspector = new TypeIntrospector {
      override def getGenericTypes(clazz: Class[_]): Array[Type] = functionParams(clazz, "accept")
    }
  }
}
