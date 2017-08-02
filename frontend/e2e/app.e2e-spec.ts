import { ClickerFrontPage } from './app.po';

describe('clicker-front App', function() {
  let page: ClickerFrontPage;

  beforeEach(() => {
    page = new ClickerFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
