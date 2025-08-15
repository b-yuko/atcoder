const { createDefaultPreset } = require("ts-jest");

const tsJestTransformCfg = createDefaultPreset().transform;

/** @type {import("jest").Config} **/
module.exports = {
  preset: 'ts-jest',
  testEnvironment: "node",
  transform: {
    ...tsJestTransformCfg,
  },

  // AtCoder用の設定追加
  roots: ['<rootDir>/src'],
  testMatch: [
    '**/*.test.ts',
    '**/*.spec.ts',
    '**/__tests__/**/*.ts',
    '**/?(*.)+(spec|test).ts'
  ],

  // テストファイルのパス設定
  moduleFileExtensions: ['ts', 'tsx', 'js', 'jsx', 'json'],

  // カバレッジ設定（任意）
  collectCoverageFrom: [
    'src/**/*.ts',
    '!src/**/*.d.ts',
    '!src/**/*.test.ts',
    '!src/**/*.spec.ts',
    '!src/template/**/*',  // テンプレートファイルは除外
  ],

  // テストのタイムアウト（AtCoderの制限時間に合わせて）
  testTimeout: 10000,
};
