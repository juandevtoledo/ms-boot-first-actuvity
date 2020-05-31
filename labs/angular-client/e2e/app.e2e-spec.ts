import { OnlinestorePage } from './app.po';

describe('onlinestore App', function() {
  let page: OnlinestorePage;

  beforeEach(() => {
    page = new OnlinestorePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
