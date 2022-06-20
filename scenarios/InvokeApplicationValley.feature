Feature: Invoke Valley

	Scenario Outline: Navigate to Valley Bank
		Given Navigate to Valley Bank


		Examples: {"dataFile":"resources/data/logintestdata.xml", "key":"login.data", 'groups':['dev']}
