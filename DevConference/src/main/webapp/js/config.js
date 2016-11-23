function config($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/index");
    $stateProvider
        .state('index', {
            url: "/index",
            templateUrl: "views/pages/conference.html",
            data: { pageTitle: 'index' }
        })
        .state('pages', {
            abstract: true,
            url: "/pages",
            templateUrl: "views/pages/common.html",
        })
        .state('pages.blank_page', {
            url: "/blank_page",
            templateUrl: "views/pages/conference.html",
            data: { pageTitle: 'Blank page' }
        })
         .state('pages.blank_page2', {
            url: "/blank_page2",
            templateUrl: "views/pages/blank-page2.html",
            data: { pageTitle: 'Another blank page' }
        })
}
angular
    .module('conference')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });