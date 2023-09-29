# kotlin_2
//иерархия <br />
interface Body; <br />
interface Brand; <br />
interface Machine: Body, Brand; <br />
abstract class Car: Machine; <br />
abstract class Bus: Car; <br />
 <br />
final class PublicBus: Bus; <br />
final class MilitaryBus: Bus; <br />
final class Truck: Car; <br />
final class Bike: Machine; <br />
 <br />
//описание <br />
 <br />
.\instance\index.kt <br />
Body и Brand - начальные интерфейсы, главное, что там содежится fun move(); (Body - интерфейс объекта (с какими то параметрами), имеющего возможность перемещаться) - объявлены с sealed, поэтому наследуется от них только наш интерфейс Machine <br />
 <br />
Machine - общий интерфейс автомобиля (и байка): двигатель, колеса ... Метод move переопределяется здесь, тк дальше идет описание "Машин", двигающихся по единому принципу <br />
 <br />
.\Main <br />
Car - машина с 4 колесами <br />
Bike - машина с 2 колесами <br />
Bus - Car с местами для пассажиров <br />
PublicBus - Bus с стоимостью за проезд <br />
MilitaryBus - Bus с пушкой <br />
Truck - Car с определенной грузоподъемностью <br />
 <br />
final class-ы имеют статик функции create - ввод данных польхователем с консоли <br />
 <br />
.\modules\indexs.kt <br />
Engine, Wheel - понятно <br />
WheelPlatform - массив колес <br />
Engine::move(WheelPlatform: "в зависимости от колес данной машины", name: "передается из класса, в котором объявлен engine") -> смещение position по какому то правилу <br />
WheelPlatform::move(speed: "просто логи") <br />
 <br />
.\source\indexs.kt <br />
 <br />
vec3 - структура Position <br />
 <br />
safe*Input - ввод с консоли с отработкой ошибок <br />
