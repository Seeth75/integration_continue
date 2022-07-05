describe('login_user_test', function() {

  it('user_should_connect', function() {
 
     cy.viewport(1920, 969)
  
     cy.visit('http://localhost:8080/login')
  
     cy.get('.row > .col-md-6 > form > .form-group > #username').click()
  
     cy.get('.row > .col-md-6 > form > .form-group > #username').type('cypress_unit@gmail.com')
  
     cy.get('.row > .col-md-6 > form > .form-group > #password').type('cypress_unit')
  
     cy.get('form > .form-group > .row > .col-sm-6 > #login-submit').click()
  
     cy.visit('http://localhost:8080/')
  
  })
 
 })
 