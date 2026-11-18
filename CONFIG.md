# Configuration / コンフィグ設定

Configuration file location / 設定ファイルの場所:
`config/apotheosis_material_things-common.toml`

---

## English

### `[hostile_mob_drops]`

| Key | Type | Default | Range | Description |
| --- | --- | --- | --- | --- |
| `enableCommonMaterialDrop` | `boolean` | `true` | `true` / `false` | Enables or disables common rarity material drops from hostile mobs. |
| `dropChance` | `double` | `0.04` | `0.0` ~ `1.0` | Base probability for a hostile mob to drop a common rarity material (`0.04` = 4%). |
| `lootingBonusPerLevel` | `double` | `0.01` | `0.0` ~ `1.0` | Additional drop probability added per level of Looting (`0.01` = +1% per level). Final chance is clamped to `1.0` (100%). |
| `requirePlayerKill` | `boolean` | `false` | `true` / `false` | When `true`, common rarity materials only drop if the hostile mob was killed by a player. |

---

## 日本語

### `[hostile_mob_drops]`

| キー | データ型 | デフォルト値 | 範囲 | 説明 |
| --- | --- | --- | --- | --- |
| `enableCommonMaterialDrop` | `boolean` | `true` | `true` / `false` | 敵モブからのコモンレアリティマテリアルドロップを有効/無効にします。 |
| `dropChance` | `double` | `0.04` | `0.0` ～ `1.0` | 敵モブがコモンレアリティマテリアルをドロップする基本確率（`0.04` = 4%）。 |
| `lootingBonusPerLevel` | `double` | `0.01` | `0.0` ～ `1.0` | エンチャント「ドロップ増加」1レベルごとに加算される確率（`0.01` = +1%/Lv）。最終確率は最大 `1.0`（100%）に制限されます。 |
| `requirePlayerKill` | `boolean` | `false` | `true` / `false` | `true` にすると、プレイヤーによって倒された場合のみドロップするようになります。 |
