# qagurugit
для выполения задания qaguru по jenkins в группе

параметры с коммандной строки:
1. value_a значение первого множителя\слагаемого
2. value_b значение второго множителя\слагаемого

Проверка, что результат операций больше нуля

запуск теста локально:
gradle jenkins_test -Dvalue_a=10 -Dvalue_b=10 

в Jenkinse параметр для gradle:

jenkins_test -Dvalue_a=${value_a} -Dvalue_b=${value_b} 

 Можно добавить параметр для запуска тестов параллельно
 -Pthreads=2

  
