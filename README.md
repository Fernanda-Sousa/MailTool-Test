# MailTool-Test
Uma empresa necessita criar emails para novos funcionários e para isso foi destacado um padrão de criação.  
 
É informado uma lista com os nomes completos e também o domínio da empresa, por exemplo:   

Lista com nomes: John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker Domínio da empresa: company.com   

- Não devem haver emails repetidos 
- O formato do email é sobrenome.primeira letra do nome do meio.primeira letra do primeiro nome @ domínio. Por exemplo: John Elvis Doe ficaria: doe.j.e@company.com 
- Quando o email gerado for igual a um existente, acrescentar um número crescente sequencial no final do nome de usuário. Por exemplo: John Doe doe.j@company.com e James Doe doe.j2@company.com 
- Não pode haver hífens nos endereços de email   

O resultado esperado seria algo como:   

John Doe <doe.j@company.com>, Peter Parker <parker.p@company.com>, Mary Jane Watson-Parker <watsonparker.m.j@company.com>, James Doe <doe.j2@company.com>, John Elvis Doe <doe.j.e@company.com>, Jane Doe <doe.j3@company.com>, Penny Parker <parker.p2@company.com>
