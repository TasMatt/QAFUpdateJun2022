Feature: Get Request

Scenario Outline: Get Request
	Given Store get request for Universities API 'storeKey'
	Then User send get request 'GetUniversity.MiddleGeorgiaState' from 'storeKey'
	And Response should have status code '200'

	Examples: