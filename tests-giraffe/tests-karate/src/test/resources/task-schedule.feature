Feature: 测试验证一下feign和ribbon
  Scenario: 超时实验
    Given url 'http://localhost:8081/taskschedule/job/1/publish'
    When method GET
    Then status 200