Feature: Invoke Google

	Scenario Outline: Navigate to Google.com
	Given Navigate to Google
	Then User Verifies DataSheet value "${browser}"

	Examples: {"dataFile":"resources/data/logintestdata.xlsx", "sheetName":"LoginSheet", 'groups':['smoke']}

	Scenario Outline: Navigate to Google.com
		Given Navigate to Google
		Then User Verifies DataSheet value "${browser}"

		Examples: {"dataFile":"resources/data/logintestdata.xml", "key":"login.data", 'groups':['smoke']}

	Scenario Outline: Navigate to Google.com
		Given Navigate to Google
		Then User Verifies DataSheet value "${browser}"

		Examples: {"dataFile":"resources/data/logintestdata.json", 'groups':['smoke']}