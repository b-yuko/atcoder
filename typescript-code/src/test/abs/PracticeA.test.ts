import { practiceA } from '../../main/abs/PracticeA';

describe('PracticeA', () => {
  let consoleSpy: jest.SpyInstance;

  beforeEach(() => {
    consoleSpy = jest.spyOn(console, 'log').mockImplementation();
  });

  afterEach(() => {
    consoleSpy.mockRestore();
  });

  test('sample1', () => {
    const input = `1\n2 3\ntest`;

    practiceA(input);

    expect(consoleSpy).toHaveBeenCalledWith('6 test');
  });

  test('sample2', () => {
    const input = `72\n128 256\nmyonmyon`;

    practiceA(input);

    expect(consoleSpy).toHaveBeenCalledWith('456 myonmyon');
  });
});
