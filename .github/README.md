

# BetterMinestom

[![license](https://img.shields.io/github/license/Minestom/Minestom?style=for-the-badge&color=b2204c)](../LICENSE)
[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=for-the-badge)](https://github.com/RichardLitt/standard-readme)  
[![javadocs](https://img.shields.io/badge/documentation-javadocs-4d7a97?style=for-the-badge)](https://javadoc.minestom.net)
[![wiki](https://img.shields.io/badge/documentation-wiki-74aad6?style=for-the-badge)](https://wiki.minestom.net/)
[![discord-banner](https://img.shields.io/discord/706185253441634317?label=discord&style=for-the-badge&color=7289da)](https://discord.gg/pkFRvqB)

THIS IS NOT THE OFFICIAL MINESTOM PROJECT BUT A FORK!!!!!! PLEASE VISIT https://github.com/Minestom/Minesto

# Why BetterMinestom?

Minestom right out of the box is unusable for most developers right out of the box, BetterMinestom Implements a plethora of changes and updates for devs to better understand. 
Minecraft has evolved a lot since its release, most of the servers today do not take advantage of vanilla features and even have to struggle because of them.
Our target audience is those who want to make a server that benefits little from vanilla features. e.g. creative, kitpvp.
The goal is to offer more performance for those who need it.
In other words, it makes sense to use Minestom when it takes less time to implement every missing vanilla feature you want than removing every vanilla feature that will slow you down.

# Advantages and Disadvantages
BetterMinestom isn't complete, .

## Advantages
* Reintroduced some of the overhead of vanilla features
* Multi-threaded
* Instance system (Collections of blocks and entities) which is much more scalable than worlds
* Open-source
* Modern API
* No more legacy NMS
* ViaVersion, Backwards Compatibility

## Disadvantages
* STILL Does not work with Bukkit/Forge/Sponge plugins or mods
* Longer to develop something playable
* Multi-threaded environments need extra consideration

# API
Even if we do not include anything by default in the game, we simplify the way you add them, here is a preview.

## Blocks
Minestom by default does not know what is a chest, you will have to tell him that it opens an inventory. 
Every "special blocks" (which aren't only visual) need a specialized handler. After applying this handler, you have a block that can be placed anywhere simply.
However, all blocks are visually there, they just won't have interaction by default.

## Entities
The terms "passive" or "aggressive" monsters do not exist, nobody stops you from making a flying chicken rushing into any players coming too close, doing so with NMS is a real mess because of obfuscation and the large inheritance.

## Inventories
It is a field where Minecraft evolved a lot, inventories are now used a lot as client<->server interface with clickable items and callback, we support these interactions natively without the need of programming your solution.

## Commands
Commands are the simplest way of communication between clients and server. Since 1.13 Minecraft has incorporated a new library denominated "Brigadier", we then integrated an API designed to use the full potential of args types.

# Credits
* The [Original Minestom Project and Its Contributers] (https://github.com/Minestom/Minestom/graphs/contributors) of the project
* [The Minecraft Coalition](https://wiki.vg/) and [`#mcdevs`](https://github.com/mcdevs) -
   protocol and file formats research.
* [The Minecraft Wiki](https://minecraft.wiki) for all their useful info
* [JProfiler](https://www.ej-technologies.com/products/jprofiler/overview.html) for their amazing Java profiler

# License
This project is licensed under the [Apache License Version 2.0](../LICENSE).
