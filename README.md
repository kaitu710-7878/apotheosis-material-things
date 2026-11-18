# Apotheosis Material Things / Apotheosis Material Things (アポセオシス・マテリアル・シングス)

- [English](#english)
- [日本語](#日本語)

---

## English

### Overview

**Apotheosis Material Things** is a Minecraft Forge 1.20.1 addon for **Apotheosis** that expands rarity material acquisition and progression, with optional compatibility for **Apotheotic Additions**, **Ancient Reforging**, and **Esoteric Reforging**.

### Features

1. **Hostile Mob Common Material Drops**
   - Adds a **4% base chance** (configurable) for all hostile mobs (`MobCategory.MONSTER`) to drop `apotheosis:common_material` directly in their loot tables (compatible with loot table viewer mods such as Advanced Loot Info, JER, and EMI Loot; verified using **Advanced Loot Info**).
   - Benefits from **Looting** enchantment (+1% per level by default, configurable).

2. **4-to-1 Rarity Material Compression Recipes**
   - Craft **4** rarity materials of any tier into **1** material of the next higher tier:
     - Common (`apotheosis:common_material`) → Uncommon (`apotheosis:uncommon_material`)
     - Uncommon (`apotheosis:uncommon_material`) → Rare (`apotheosis:rare_material`)
     - Rare (`apotheosis:rare_material`) → Epic (`apotheosis:epic_material`)
     - Epic (`apotheosis:epic_material`) → Mythic (`apotheosis:mythic_material`)
     - Mythic (`apotheosis:mythic_material`) → Ancient (`apotheosis:ancient_material`)
   - **Optional Integration (Apotheotic Additions):**
     - Ancient (`apotheosis:ancient_material`) → Artifact (`apotheotic_additions:artifact_material`)
     - Artifact (`apotheotic_additions:artifact_material`) → Heirloom (`apotheotic_additions:heirloom_material`)
     - Heirloom (`apotheotic_additions:heirloom_material`) → Esoteric (`apotheotic_additions:esoteric_material`)

3. **Esoteric Reforging Table Recipe (Optional Integration)**
   - When **Apotheotic Additions**, **Ancient Reforging**, and **Esoteric Reforging** are all installed, adds a shaped crafting recipe for the **Esoteric Reforging Table** (`esotericreforging:esoteric_reforging_table`):
     - Top-center, middle-left, middle-right: **Esoteric Material** (`apotheotic_additions:esoteric_material`) ×3
     - Center: **Ancient Reforging Table** (`ancientreforging:ancient_reforging_table`) ×1
     - Bottom row: **Echo Shard** (`minecraft:echo_shard`) ×3

### Installation

1. Install **Minecraft 1.20.1** with **Minecraft Forge 47.4.0+**.
2. Install **Apotheosis** (and its dependencies: Placebo, Apothic Attributes).
3. *(Optional)* Install **Apotheotic Additions**, **Ancient Reforging**, and/or **Esoteric Reforging** for extended recipes.
4. Place `apotheosis_material_things-<version>.jar` into your `mods/` folder.
   - **Multiplayer:** Server-side only compatible. Installing this mod only on the server is sufficient (clients do not need to install it).

### License

Licensed under **GPL-3.0-or-later**. See [LICENSE](LICENSE) for details.

---

## 日本語

### 概要

**Apotheosis Material Things** は、Minecraft Forge 1.20.1 向けの **Apotheosis** アドオンMODです。レアリティマテリアルの入手手段と上位圧縮ルートを追加し、**Apotheotic Additions**、**Ancient Reforging**、**Esoteric Reforging** とのオプション連携に対応しています。

### 主な機能

1. **敵モブからのコモンレアリティマテリアルドロップ**
   - すべての敵モブ（`MobCategory.MONSTER`）のルートテーブルに、**4%**（設定変更可能）の確率で `apotheosis:common_material` をドロップするプールを直接追加します（Advanced Loot Info、JER、EMI Loot などのルートテーブル表示系MODでの表示に対応しており、**Advanced Loot Info** を用いて表示対応テストを実施済みです）。
   - **ドロップ増加（Looting）** エンチャントの恩恵を受けます（デフォルトでレベルごとに +1%、設定変更可能）。

2. **4:1 マテリアル圧縮レシピ**
   - 同じレアリティマテリアル **4つ** をクラフトすることで、1段階上位のマテリアル **1つ** に圧縮できます：
     - コモン (`apotheosis:common_material`) → アンコモン (`apotheosis:uncommon_material`)
     - アンコモン (`apotheosis:uncommon_material`) → レア (`apotheosis:rare_material`)
     - レア (`apotheosis:rare_material`) → エピック (`apotheosis:epic_material`)
     - エピック (`apotheosis:epic_material`) → ミシック (`apotheosis:mythic_material`)
     - ミシック (`apotheosis:mythic_material`) → エンシェント (`apotheosis:ancient_material`)
   - **オプション連携（Apotheotic Additions 導入時）:**
     - エンシェント (`apotheosis:ancient_material`) → アーティファクト (`apotheotic_additions:artifact_material`)
     - アーティファクト (`apotheotic_additions:artifact_material`) → エアルーム (`apotheotic_additions:heirloom_material`)
     - エアルーム (`apotheotic_additions:heirloom_material`) → エソテリック (`apotheotic_additions:esoteric_material`)

3. **エソテリックリフォージングテーブルのクラフトレシピ（オプション連携）**
   - **Apotheotic Additions**、**Ancient Reforging**、**Esoteric Reforging** のすべてが導入されている場合、**Esoteric Reforging Table** (`esotericreforging:esoteric_reforging_table`) のクラフトレシピが追加されます：
     - 上段中央・中段左・中段右：エソテリックマテリアル (`apotheotic_additions:esoteric_material`) ×3
     - 中央：エンシェントリフォージングテーブル (`ancientreforging:ancient_reforging_table`) ×1
     - 下段一列：残響の欠片 (`minecraft:echo_shard`) ×3

### 導入手順

1. **Minecraft 1.20.1** および **Minecraft Forge 47.4.0 以降** を導入します。
2. **Apotheosis**（および前提MODの Placebo、Apothic Attributes）を導入します。
3. *(任意)* 拡張レシピを利用する場合は **Apotheotic Additions**、**Ancient Reforging**、**Esoteric Reforging** を導入します。
4. `apotheosis_material_things-<version>.jar` を `mods/` フォルダに配置します。
   - **マルチプレイについて:** サーバー側のみの導入で動作します（クライアント側への導入は不要です）。

### ライセンス

本MODは **GPL-3.0-or-later** のもとで公開されています。詳細は [LICENSE](LICENSE) を参照してください。
