# Changelog / 変更履歴

## [1.0.1-alpha] - 2026-11-18

### English
- Switched hostile mob common material drops from Global Loot Modifiers to direct `LootPool` injection via `LootTableLoadEvent`, enabling loot table viewer mods (such as JER and EMI Loot) to display the drop and its Looting chance.

### 日本語
- 敵モブのコモンレアリティマテリアルドロップを Global Loot Modifier から `LootTableLoadEvent` によるルートテーブルへの直接 `LootPool` 追加方式に変更し、JER や EMI Loot などのルートテーブル表示系MODでドロップ情報・ドロップ増加確率が表示されるように修正。

## [1.0.0-alpha] - 2026-11-18

### English
- Initial alpha release for Minecraft 1.20.1 (Forge).
- Added Global Loot Modifier (`apotheosis_material_things:add_common_material`) to drop `apotheosis:common_material` from all hostile mobs with a 4% base chance affected by Looting (+1% per level by default).
- Added 4-to-1 shapeless compression recipes from Common up to Ancient (`apotheosis:ancient_material`).
- Added optional conditional compression recipes for Apotheotic Additions (`artifact_material`, `heirloom_material`, `esoteric_material`).
- Added optional conditional shaped recipe for `esotericreforging:esoteric_reforging_table` using Ancient Reforging Table, Echo Shards, and Esoteric Materials.
- Added common configuration (`apotheosis_material_things-common.toml`) and bilingual documentation (`en_us` / `ja_jp`).

### 日本語
- Minecraft 1.20.1 (Forge) 向けの初期 Alpha リリース。
- すべての敵モブのルートテーブルに、基本 4%（ドロップ増加エンチャントでレベルごとに +1%）の確率で `apotheosis:common_material` をドロップする Global Loot Modifier (`apotheosis_material_things:add_common_material`) を追加。
- コモンからエンシェント (`apotheosis:ancient_material`) までの 4:1 無定形圧縮レシピを追加。
- Apotheotic Additions 導入時向けのオプション連携圧縮レシピ（`artifact_material`、`heirloom_material`、`esoteric_material`）を追加。
- Apotheotic Additions・Ancient Reforging・Esoteric Reforging 導入時向けのオプション連携レシピとして `esotericreforging:esoteric_reforging_table` のクラフトレシピを追加。
- 共通コンフィグ (`apotheosis_material_things-common.toml`) および日英バイリンガル対応ドキュメント・言語ファイルを追加。
