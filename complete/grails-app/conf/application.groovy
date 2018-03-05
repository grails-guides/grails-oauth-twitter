grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/dbconsole/**',      filters: 'none'],
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails {
	plugin {
		springsecurity {
			rest {
				oauth {
					frontendCallbackUrl = { String tokenValue -> "http://localhost:8080/successfullyLoggedIn/index#token=${tokenValue}" } //<1>
					twitter {
						client = org.pac4j.oauth.client.TwitterClient //<2>
						key = 'RN9ffChYIdMIvvbZ4sLAyKwGl' //<3>
						secret = 'LdkW63J56ZlaGVPwQE2soCItWRRB6OiEJLPHHGS2Cu1NIKHzS4' //<4>
						defaultRoles = ['ROLE_USER', 'ROLE_TWITTER'] //<5>
					}
				}
			}
		}
	}
}

grails.plugin.springsecurity.providerNames = ['anonymousAuthenticationProvider'] // <6>
