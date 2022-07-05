describe('register_user_tes', function() {

  it('user_should_register', function() {
 
     cy.viewport(1920, 969)
  
     cy.visit('http://localhost:8080/login?logout')
  
     cy.get('.col-md-6 > form > .form-group > span > a').click()
  
     cy.visit('http://localhost:8080/registration')
  
     cy.get('.row > .col-md-6 > form > .form-group > #firstName').click()
  
     cy.get('.row > .col-md-6 > form > .form-group > #firstName').type('unitest1')
  
     cy.get('.row > .col-md-6 > form > .form-group > #lastName').type('unitest2')
  
     cy.get('.row > .col-md-6 > form > .form-group > #email').type('unitest@unit.com')
  
     cy.get('.row > .col-md-6 > form > .form-group > #confirmEmail').type('unitest@unit.com')
  
     cy.get('.row > .col-md-6 > form > .form-group > #password').type('123')
  
     cy.get('.row > .col-md-6 > form > .form-group > #confirmPassword').type('123')
  
     cy.get('.row > .col-md-6 > form > .form-group > #terms').click()
  
     cy.get('.row > .col-md-6 > form > .form-group > #terms').check('true')
  
     cy.get('.row > .col-md-6 > form > .form-group > .btn').click()
  
     cy.visit('http://localhost:8080/registration?success')
  
  })
 
 })
 