Feature: Invoke Valley

	Scenario Outline: Navigate to Valley Bank
		Given Navigate to Valley Bank
		And Validate top menu displays


		Examples: {"dataFile":"resources/data/logintestdata.xml", "key":"login.data", 'groups':['dev']}
