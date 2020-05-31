db.auth('admin', 'secret')

db = db.getSiblingDB('productdb')

db.createUser({
  user: 'product-user',
  pwd: 'product-password',
  roles: [
    {
      role: 'root',
      db: 'admin',
    },
  ],
});